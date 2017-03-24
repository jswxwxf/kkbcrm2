/// <reference path="../../lib/app.d.ts" />

'use strict';

export import utilService = require('./util-service');
export import storeService = require('./store-service');
export import baseDialogController = require('./base-dialog-controller');
import {Utils} from "./Utils";

export var load = (app: angular.IModule) => {
  app.controller(baseDialogController.controllerName, baseDialogController.Controller)
    .service(utilService.serviceName, utilService.Service)
    .service(storeService.serviceName, storeService.Service)
    .run(['$rootScope', utilService.serviceName, ($rootScope, utilService: utilService.Service) => {
      $rootScope.parseBool = Utils.parseBool;
      $rootScope.isEmpty = _.isEmpty;
    }]);
};