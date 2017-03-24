/// <reference path="../../../lib/app.d.ts" />
import IResourceClass = angular.resource.IResourceClass;
'use strict';

import common = require('../../utility/index');
import {Config} from "../../config/config";

abstract class BaseService {

  constructor(
    private $baseInjector: angular.auto.IInjectorService,
    private $baseQ: angular.IQService,
    private $baseHttp: angular.IHttpService,
    private $baseResource: angular.resource.IResourceService,
    private baseUtilService: common.utilService.Service) {

  }

  private _processUrl(url) {
    return `${Config.baseUrl}/api/${url}`;
  }

  /**
   * http
   */

  _get(url, opts?): angular.IHttpPromise<any> {
    return this.$baseHttp.get(this._processUrl(url), opts);
  }

  _post(url, data, opts?): angular.IHttpPromise<any> {
    return this.$baseHttp.post(this._processUrl(url), data, opts);
  }

  _put(url, data, opts?): angular.IHttpPromise<any> {
    return this.$baseHttp.put(this._processUrl(url), data, opts);
  }

  _delete(url, opts?): angular.IHttpPromise<any> {
    return this.$baseHttp.delete(this._processUrl(url), opts);
  }

  /**
   * resources
   */

  private _resources = {};

  setResource(k, url = `${k}s/:${k}`, params?) {
    if (!params) {
      params = {}; params[k] = `@${k}`;
    }
    this._resources[k] = this.$baseResource(this._processUrl(url), params);
  }

  getResource(k): angular.resource.IResourceClass<any> {
    return this._resources[k];
  }

  _rGet(k, id): angular.IHttpPromise<any> {
    return this.getResource(k).get(this._resolveIdObj(k, id)).$promise;
  }

  _rSave(k, data): angular.IHttpPromise<any> {
    return this.getResource(k).save(data).$promise;
  }

  _rRemove(k, id): angular.IHttpPromise<any> {
    return this.getResource(k).remove(this._resolveIdObj(k, id)).$promise;
  }

  private _resolveIdObj(k, id) {
    var idObj = id;
    if (!angular.isObject(idObj)) {
      idObj = {}; idObj[k] = id;
    }
    return idObj;
  }

}

export class Service extends BaseService {}