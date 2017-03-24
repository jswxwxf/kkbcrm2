/// <reference path="../../../lib/app.d.ts" />

'use strict';

import common = require('../../utility/index');
import services = require('../../components/services/index');
//import models = require('../../components/models/index');
import enums = require('../../enums/index');
import {BaseController} from "../../utility/base-controller";

export var controllerName = 'base.UserController';

class UserController extends BaseController {

  user;

  static $inject = ['$injector', '$scope', '$state', common.utilService.serviceName, services.userService.serviceName];

  constructor(private $injector, private $scope, private $state, private utilService: common.utilService.Service, private userService: services.userService.Service) {
    super($injector, $scope, utilService);
  }

  login() {
    this.utilService.showSpinner();
    this.userService.login(this.user).success((data) => {
      this.$scope.$root.$broadcast(enums.events.Events.user_loggedin, data.user);
      this.utilService.returnBack('share.region');
    }).finally(() => this.utilService.hideSpinner());
  }

}

export class Controller extends UserController {}