/// <reference path="../../../../lib/app.d.ts" />

'use strict';

import {Utils} from "../../../utility/Utils";

import userController = require('./user-controller');
import dialogController = require('./dialog-controller');

export var load = (app: angular.IModule) => {
  app.controller(userController.controllerName, userController.Controller)
    .controller(dialogController.controllerName, dialogController.Controller);
};

export var states = ($stateProvider) => {

  $stateProvider
    .state('share.user', {
      url: '/user',
      templateUrl: 'features/share/user/user.html',
      ncyBreadcrumb: {
        label: '用户信息'
      },
      controller: userController.controllerName,
      controllerAs: 'ctrl',
      resolve: {
        depends: Utils.dependsModules(['datatables'])
      }
    });

};
