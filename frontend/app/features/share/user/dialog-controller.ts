/// <reference path="../../../../lib/app.d.ts" />

'use strict';

import common = require('../../../utility/index');
import services = require('../../../components/services/index');
//import models = require('../../../components/models/index');

export var controllerName = 'share.user.DialogController';

class DialogController extends common.baseDialogController.Controller {

  static $inject = ['$scope', '$uibModalInstance', 'data', services.commonService.serviceName];

  constructor(private $scope, private $modalInstance, private data, private commonService: services.commonService.Service) {
    super($scope, $modalInstance, data);
  }

  save() {
    this.commonService.saveRegion(this.data.region).then(() => this.ok());
  }

}

export class Controller extends DialogController {}