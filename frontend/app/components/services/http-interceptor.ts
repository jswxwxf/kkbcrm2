/// <reference path="../../../lib/app.d.ts" />
'use strict';

import common = require('../../utility/index');
//import models = require('../models/index');
import enums = require('../../enums/index');

export var serviceName = 'httpInterceptor';

class HttpInterceptor {

  static $inject = ['$injector', '$q', '$rootScope', common.storeService.serviceName];

  constructor(private $injector: angular.auto.IInjectorService, private $q: angular.IQService, private $rootScope: angular.IRootScopeService, private storeService: common.storeService.Service) {}

  request = (config) => {
    var token = this.storeService.getToken();
    if (token) config.headers['Authorization'] = `Bearer ${token}`;
    return config;
  };

  requestError = (rejection) => {
    return this.$q.reject(rejection);
  };

  response = (response) => {
    return response;
  };

  responseError = (rejection) => {
    if (rejection.status == 0) {
      this.$rootScope.$broadcast(enums.events.Events.network_error, rejection.data, rejection);
      return this.$q.reject(rejection);
    }
    if (rejection.data && rejection.status == 401) {
      this.$rootScope.$broadcast(enums.events.Events.token_expired, rejection.data, rejection);
      return this.$q.reject(rejection);
    }
    var errorHandler: any = _.get(rejection, 'config.errorHandler');
    if (errorHandler && angular.isFunction(errorHandler)) {
      var handled = errorHandler(rejection.data, rejection);
      if (handled === true) return this.$q.reject(rejection);
    }
    if (rejection.config && rejection.config.errorHandled) return this.$q.reject(rejection);
    this.$rootScope.$broadcast(enums.events.Events.result_failed, rejection.data || {}, rejection || {});
    return this.$q.reject(rejection);
  }

}

export class Service extends HttpInterceptor {};

export var load = (app: angular.IModule) => {

  app.config([ '$httpProvider', ($httpProvider: angular.IHttpProvider) => {

    $httpProvider.interceptors.push(serviceName);

  }]).run(['$rootScope', common.utilService.serviceName, ($rootScope, utilService: common.utilService.Service) => {

    $.ajaxSetup({
      beforeSend: (jqXHR, settings) => {
        var token = utilService.getToken();
        if (token) jqXHR.setRequestHeader("Authorization",`Bearer ${token}`);
      },
      complete: (jqXHR, status) => {
        if (jqXHR.status == 401) {
          setTimeout(() => {
            $rootScope.$broadcast(enums.events.Events.token_expired);
            $rootScope.$apply();
          }, 0);
        }
      }
    });

  }]);


};
