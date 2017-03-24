/// <reference path="../../../lib/app.d.ts" />

'use strict';

import baseService = require('./base-service');
import common = require('../../utility/index');

export var serviceName = 'userService';

class UserService extends baseService.Service {

  static $inject = ['$injector', '$q', '$http', '$resource', common.utilService.serviceName];

  constructor(private $injector, private $q: angular.IQService, private $http: angular.IHttpService, private $resource, public utilService) {
    super($injector, $q, $http, $resource, utilService);
    super.setResource('user');
  }

  register(user) {
    //return this._post('register', user).success((data) => {
    //  this._setToken(data.token);
    //});
  }

  login(user) {
    return this._post('login', user).success((data) => {
      this._setToken(data.token);
    });
  }

  private _setToken(token) {
    //this.userCache.removeAll();
    this.utilService.setToken(token);
  }

  deleteToken() {
    //this.userCache.removeAll();
    this.utilService.deleteToken();
  }

  isLoggedIn() {
    return !_.isEmpty(this.utilService.getToken());
  }

}

export class Service extends UserService {};