/// <reference path="../../lib/app.d.ts" />

'use strict';

import common = require('./index');
import {BaseController} from "./base-controller";
import {Config} from "../config/config";

export abstract class DatatableController extends BaseController {

  dtInst: any = {};

  dtOptionsBuilder: any = this.$dtInjector.get('DTOptionsBuilder');
  dtColumnBuilder: any = this.$dtInjector.get('DTColumnBuilder');
  dtColumnDefBuilder: any = this.$dtInjector.get('DTColumnDefBuilder');
  $dtCompile: angular.ICompileService = <angular.ICompileService> this.$dtInjector.get('$compile');

  constructor(private $dtInjector: angular.auto.IInjectorService, private $dtScope: angular.IScope, private dtUtilService: common.utilService.Service) {
    super($dtInjector, $dtScope, dtUtilService);
  }

  createDTOptions(url): any {
    return this.dtOptionsBuilder.newOptions()
      .withOption('ajax', {
        url: this._processUrl(url),
        type: 'post',
        error: (jqXHR, status, errorThrown) => { console.log(errorThrown) } // 阻止 DataTables 弹出错误
      })
      .withDataProp('data')
      .withOption('processing', true)
      .withOption('serverSide', true)
      .withPaginationType('full_numbers')
      .withDOM("Tt<'row DTTTFooter'rip>")
      .withBootstrap()
      //.withTableToolsButtons([
      //  'copy',
      //  'print', {
      //    'sExtends': 'collection',
      //    'sButtonText': 'Save',
      //    'aButtons': ['csv', 'xls', 'pdf']
      //  }
      //])
      .withColReorder()
      .withOption('responsive', true)
      .withOption('createdRow', (row) => this._compileRow(row));
    //.withButtons(['print', 'excel', {
    //  text: 'Some button',
    //  key: '1',
    //  action: function (e, dt, node, config) {
    //    alert('Button activated');
    //  }
    //}]);
  }

  private _compileRow(row) {
    this.$dtCompile(angular.element(row).contents())(this.$dtScope);
  }

  private _processUrl(url) {
    return `${Config.baseUrl}/api/datatable/${url}`;
  }

  actionsHtml(data, type, full, meta) {
    return `
      <div class="btn-group">
          <a class="btn btn-default" href="javascript:void(0);" ng-click="ctrl.edit(${data.code})"><i class="fa fa-edit"></i> 编辑</a>
          <a class="btn btn-default dropdown-toggle" data-toggle="dropdown" href="javascript:void(0);"><i class="fa fa-angle-down"></i></a>
          <ul class="dropdown-menu">
              <li>
                  <a href="javascript:void(0);" ng-click="ctrl.delete(${data.code})"><i class="fa fa-trash-o"></i> 删除</a>
              </li>
          </ul>
      </div>
    `;
  }

}