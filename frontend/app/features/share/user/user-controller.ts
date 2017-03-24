/// <reference path="../../../../lib/app.d.ts" />

'use strict';

import common = require('../../../utility/index');
import services = require('../../../components/services/index');
//import models = require('../../../components/models/index');
//import {BaseController} from "../../../utility/base-controller";
import dialogController = require('./dialog-controller');
import {DatatableController} from "../../../utility/datatable-controller";

export var controllerName = 'share.user.UserController';

class UserController extends DatatableController {

  query: any = {};

  dtOptions: any = this.createDTOptions('users');

  dtColumns = [
    this.dtColumnBuilder.newColumn('username').withTitle('用户名'),
    this.dtColumnBuilder.newColumn('mobile').withTitle('手机'),
    this.dtColumnBuilder.newColumn(null).withTitle('行动').notSortable().renderWith(this.actionsHtml)
  ];

  static $inject = ['$injector', '$scope', common.utilService.serviceName, services.commonService.serviceName];

  constructor(private $injector: angular.auto.IInjectorService, private $scope: angular.IScope, private utilService: common.utilService.Service) {
    super($injector, $scope, utilService);
  }

}

export class Controller extends UserController {}