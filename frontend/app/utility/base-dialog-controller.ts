/// <reference path="../../lib/app.d.ts" />

'use strict';

//import services = require('../../../components/services/index');
//import models = require('../../../components/models/index');
//import {BaseController} from "../../../utility/base-controller";

export var controllerName = 'utility.BaseDialogController';

class BaseDialogController {

  yes = this.ok;
  no = this.cancel;
  close = this.cancel;

  static $inject = ['$scope', '$uibModalInstance', 'data'];

  constructor(private $baseScope, private $baseModalInstance, private baseData) {}

  ok() {
    this.$baseModalInstance.close('ok');
  }

  cancel() {
    this.$baseModalInstance.dismiss('cancel');
  }

}

export class Controller extends BaseDialogController {}