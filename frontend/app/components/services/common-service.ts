/// <reference path="../../../lib/app.d.ts" />

'use strict';

import baseService = require('./base-service');
import common = require('../../utility/index');
//import models = require('../models/index');

export var serviceName = 'commonService';

class CommonService extends baseService.Service {

  static $inject = ['$injector', '$q', '$http', '$resource', common.utilService.serviceName];

  constructor(private $injector, private $q: angular.IQService, private $http: angular.IHttpService, private $resource, public utilService) {
    super($injector, $q, $http, $resource, utilService);
    super.setResource('region');
  }

  getRegion(code): angular.IPromise<any> {
    return this._rGet('region', code);
  }

  saveRegion(region): angular.IPromise<any> {
    return this._rSave('region', region);
  }

  deleteRegion(code): angular.IPromise<any> {
    return this._rRemove('region', code);
  }

}

export class Service extends CommonService {};