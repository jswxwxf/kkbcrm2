/// <reference path="../../../../lib/app.d.ts" />

'use strict';

import common = require('../../../utility/index');
import services = require('../../../components/services/index');
//import models = require('../../../components/models/index');
//import {BaseController} from "../../../utility/base-controller";
import dialogController = require('./dialog-controller');
import {DatatableController} from "../../../utility/datatable-controller";

export var controllerName = 'share.region.RegionController';

class RegionController extends DatatableController {

  query: any = {};

  dtOptions: any = this.createDTOptions('regions');

  dtColumns = [
    this.dtColumnBuilder.newColumn('code').withTitle('代码'),
    this.dtColumnBuilder.newColumn('cnName').withTitle('地区'),
    this.dtColumnBuilder.newColumn(null).withTitle('行动').notSortable().renderWith(this.actionsHtml)
  ];

  static $inject = ['$injector', '$scope', common.utilService.serviceName, services.commonService.serviceName, services.commonService.serviceName];

  constructor(private $injector: angular.auto.IInjectorService, private $scope: angular.IScope, private utilService: common.utilService.Service, private commonService: services.commonService.Service) {
    super($injector, $scope, utilService);
  }

  create() {
    this.utilService.dialog('share/region/edit.html', dialogController.controllerName, { new: true }, { size: 'sm' }).result.then(() => this.dtInst.reloadData());
  }

  edit(code) {
    this.commonService.getRegion(code).then((data) => {
      return this.utilService.dialog('share/region/edit.html', dialogController.controllerName, { region: data }, { size: 'sm' }).result;
    }).then(() => this.dtInst.reloadData());
  }

  delete(code) {
    this.utilService.confirm('真的要删除吗?').result.then(() => {
      this.commonService.deleteRegion(code).then(() => this.dtInst.reloadData());
    });
  }

  search() {
    this.dtInst.DataTable.columns(1).search(this.query.city).draw();
  }

}

export class Controller extends RegionController {}