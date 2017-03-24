/// <reference path="../../../../lib/app.d.ts" />

'use strict';

import {Utils} from "../../../utility/Utils";

import regionController = require('./region-controller');
import dialogController = require('./dialog-controller');

export var load = (app: angular.IModule) => {
  app.controller(regionController.controllerName, regionController.Controller)
    .controller(dialogController.controllerName, dialogController.Controller);
};

export var states = ($stateProvider) => {

  $stateProvider
    .state('share.region', {
      url: '/region',
      templateUrl: 'features/share/region/region.html',
      ncyBreadcrumb: {
        label: '地区信息'
      },
      controller: regionController.controllerName,
      controllerAs: 'ctrl',
      resolve: {
        depends: Utils.dependsModules(['datatables'])
      }
    });

};
