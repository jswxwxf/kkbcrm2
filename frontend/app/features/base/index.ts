/// <reference path="../../../lib/app.d.ts" />

'use strict';

//import config = require('../../config/config');
//import common = require('../../utility/index');
//import services = require('../../components/services/index');
//import enums = require('../../enums/index');
//
//import oauth = require('./oauth/index');
//import intro = require('./intro/index');

//export import beyondController = require('./beyond-controller');
export import menuController = require('./menu-controller');
export import userController = require('./user-controller')
//export import welcomeController = require('./welcome-controller');

export var load = (app: angular.IModule) => {
  //oauth.load(app);
  //intro.load(app);
  app.controller(userController.controllerName, userController.Controller)
    .controller(menuController.controllerName, menuController.Controller);
  //  .controller(welcomeController.controllerName, welcomeController.Controller);
};

export var states = ($stateProvider: angular.ui.IStateProvider) => {

  $stateProvider.state('login', {
    url: '/login',
    templateUrl: 'features/base/login.html',
    controller: userController.controllerName,
    controllerAs: 'ctrl'
  });

};
