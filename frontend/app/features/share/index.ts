/// <reference path="../../../lib/app.d.ts" />

'use strict';

//import config = require('../../config/config');
//import common = require('../../utility/index');
//import services = require('../../components/services/index');
//import enums = require('../../enums/index');

import region = require('./region/index');
import user = require('./user/index');

//import dataTableController = require('./datatable-controller');
//export import userController = require('./user-controller')
//export import welcomeController = require('./welcome-controller');

export var load = (app: angular.IModule) => {
  region.load(app);
  user.load(app);
  //app.controller(dataTableController.controllerName, dataTableController.Controller);
  //  .controller(userController.controllerName, userController.Controller)
  //  .controller(welcomeController.controllerName, welcomeController.Controller);
};

export var states = ($stateProvider) => {

  $stateProvider
    .state('share', {
      abstract: true,
      url: '/share',
      templateUrl: 'features/base/base.html'
    });

  region.states($stateProvider);
  user.states($stateProvider);

};