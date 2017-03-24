/// <reference path="../../lib/app.d.ts" />

'use strict';

export abstract class Utils {

  static parseBool(val, defVal = false) {
    if (angular.isUndefined(val)) return defVal;
    if (val == 'true') return true;
    return false;
  }

  static toImageData(image) {
    return {
      data: image.base64,
      filename: image.filename
    }
  }

  static formatDate(dt) {
    return moment(dt).format('YYYY-MM-DD');
  }

  static applyMixins(derivedCtor: any, baseCtors: any[]) {
    baseCtors.forEach(baseCtor => {
      Object.getOwnPropertyNames(baseCtor.prototype).forEach(name => {
        derivedCtor.prototype[name] = baseCtor.prototype[name];
      });
    });
  }

  static loadModule(module, app, $stateProvider) {
    return ['$match', '$state', '$ocLazyLoad', '$location', ($match, $state, $ocLazyLoad, $location) => {
      var moduleName = module + 'Module';
      //$.getScript(`dist/modules/${moduleName}.js`).done(() => {
      //System.import(`dist/modules/${moduleName}.js`).then(() => {
      $ocLazyLoad.load(`dist/modules/${moduleName}.js`).then(() => {
        var moduleCfg: any = window[moduleName];
        var stateName = _.compact([module, $match.path.substr(1)]).join('.');
        // check for module loaded
        if (moduleCfg.loaded) {
          return $state.transitionTo(stateName, $location.search());
        }
        moduleCfg.load(app);
        //setTimeout(() => moduleCfg.states($stateProvider), 0);
        moduleCfg.states(app, $stateProvider);
        moduleCfg.loaded = true;
        // ... and then transitionTo
        $state.transitionTo(stateName, $location.search());
      });
    }];
  }

  static dependsModules(modules) {
    return [ '$ocLazyLoad', ($ocLazyLoad) => $ocLazyLoad.load(modules, { serie: true }) ]
  }

}