/// <reference path="../../../lib/app.d.ts" />

'use strict';

import common = require('../../utility/index');
import enums = require('../../enums/index');
import services = require('../../components/services/index');
//import models = require('../../components/models/index');
import {BaseController} from "../../utility/base-controller";

export var controllerName = 'MenuController';

class MenuController extends BaseController {

  userLoggedIn = false;
  user;

  static $inject = ['$injector', '$scope', '$state', '$http', common.utilService.serviceName, services.userService.serviceName];

  constructor(private $injector: angular.auto.IInjectorService, private $scope: angular.IScope, private $state, private $http: angular.IHttpService, private utilService: common.utilService.Service, private userService: services.userService.Service) {

    super($injector, $scope, utilService);

    $scope.$on(enums.events.Events.user_loggedin, this.onUserLoggedIn.bind(this));
    $scope.$on(enums.events.Events.user_loggedout, this.onUserLoggedOut.bind(this));
    //$scope.$on(enums.events.Events.user_updated, this.onUserUpdated.bind(this));
    $scope.$on(enums.events.Events.token_expired, this.onTokenExpired.bind(this));
    $scope.$on(enums.events.Events.result_succeed, this.onResultSucceed.bind(this));
    $scope.$on(enums.events.Events.result_failed, this.onResultFailed.bind(this));
    $scope.$on(enums.events.Events.network_error, this.onNetworkError.bind(this));

    //if (userService.isLoggedIn()) this.onUserUpdated();

  }

  onUserLoggedIn(e, user) {
    this.user = user;
    this.userLoggedIn = true;
  }

  onUserLoggedOut() {
    this.user = null;
    this.userLoggedIn = false;
  }

  //onUserUpdated() {
  //  this.utilService.showSpinner();
  //  this.userService.getProfile().success((data) => this.onUserLoggedIn(null, data.data)).finally(() => this.utilService.hideSpinner());
  //}

  onTokenExpired(e, result) {
    this.utilService.hideSpinner(true);
    this.user = null;
    this.userLoggedIn = false;
    this.utilService.handleLogin();
  }

  onResultSucceed(e, result) {
    this.utilService.notify(result.msg);
  }

  onNetworkError(e, result) {
    //this.utilService.notify('您的网络可能出现了问题，请稍后再试。');
  }

  onResultFailed(e, result, rejection) {
    var message = result.error;
    if (rejection.status == 415) return this.utilService.error("服务器无法理解您的请求！");
    if (result.errors) {
      message = _.map(result.errors, (error: any) => error.field + error.message).join('<br/>');
    }
    message = message || result.msg || result.message;
    this.utilService.error(message);
  }

}

export class Controller extends MenuController {}