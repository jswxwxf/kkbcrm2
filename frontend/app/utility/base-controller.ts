/// <reference path="../../lib/app.d.ts" />

'use strict';

import common = require('./index');

export abstract class BaseController {

  isEmpty(v) {
    return _.isEmpty(v);
  }

  constructor(private $baseInjector: angular.auto.IInjectorService, private $baseScope: angular.IScope, private baseUtilService: common.utilService.Service) {}

}