/// <reference path="../../lib/app.d.ts" />

'use strict';

var _isGreen = _.startsWith(location.host, 'green.');

var _isStaging = /\.test\./.test(location.host) || /\.lichengbao\./.test(location.host);

export abstract class Config {

  static baseUrl = `//${location.host}`;

  static getStoragePrefix = () => `${location.hostname}-`;

  static isPhantomState = (state: angular.ui.IState) => {
    return _.includes([
      'login', 'signup', 'forget',
      'user.region.add', 'user.region.edit',
      'oauth.detail', 'oauth.bind',
      'token'
    ], state.name);
  }

}
