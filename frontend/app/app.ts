/// <reference path="../lib/app.d.ts" />

'use strict';

var app = angular.module('lcbman', [
  'ngAnimate',
  'ngCookies',
  'ngResource',
  'ngSanitize',
  'ngTouch',
  'ngStorage',
  'ui.router',
  'ncy-angular-breadcrumb',
  'ui.bootstrap',
  'ui.utils',
  'dialogs.main',
  'blockUI',
  'oc.lazyLoad'
]);

import {Config} from './config/config';
import {Utils} from "./utility/Utils";

import depends = require('./config/depends'); depends.load(app);
import common = require('./utility/index'); common.load(app);
import directives = require('./components/directives/index'); directives.load(app);
//import filters = require('./components/filters/index'); filters.load(app);
import services = require('./components/services/index'); services.load(app);
import enums = require('./enums/index');

/* features */
import base = require('./features/base/index'); base.load(app);
import share = require('./features/share/index'); share.load(app);

app.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider: angular.ui.IStateProvider, $urlRouterProvider: angular.ui.IUrlRouterProvider) {

  base.states($stateProvider);
  share.states($stateProvider);

  //$urlRouterProvider.otherwise('/app/dashboard');

}]).config(['$localStorageProvider', '$breadcrumbProvider', ($localStorageProvider, $breadcrumbProvider) => {

  $breadcrumbProvider.setOptions({
    template: '<ul class="breadcrumb"><li><i class="fa fa-home"></i><a href="#">主页</a></li><li ng-repeat="step in steps" ng-class="{active: $last}" ng-switch="$last || !!step.abstract"><a ng-switch-when="false" href="{{step.ncyBreadcrumbLink}}">{{step.ncyBreadcrumbLabel}}</a><span ng-switch-when="true">{{step.ncyBreadcrumbLabel}}</span></li></ul>'
  });

  $localStorageProvider.setKeyPrefix(Config.getStoragePrefix());

}]).run(['$rootScope', '$state', '$stateParams', common.utilService.serviceName, ($rootScope, $state, $stateParams, utilService: common.utilService.Service) => {

  $rootScope.$on('$stateChangeStart', (event, toState, toParams, fromState, fromParams) => {
    utilService.rememberState(toState, toParams);
  });

  window.addEventListener('offline', () => {
    utilService.showSpinner('目前没有网络');
  });
  window.addEventListener('online', () => {
    utilService.hideSpinner();
  });

  $rootScope.lcbConfig = Config;

  $rootScope.$on('$stateChangeSuccess', (event, toState) => {
    var title = 'Default Title';
    var description = '';
    if (toState.ncyBreadcrumb && toState.ncyBreadcrumb.label) title = toState.ncyBreadcrumb.label;
    if (toState.ncyBreadcrumb && toState.ncyBreadcrumb.description) description = toState.ncyBreadcrumb.description;
    setTimeout(() => {
      var el = $('.page-header h1')
      if(description == '')
        el.text(title);
      else
        el.html(title + ' <small> <i class="fa fa-angle-right"> </i> '+ description + ' </small>');
    }, 0);
  });

}]);
