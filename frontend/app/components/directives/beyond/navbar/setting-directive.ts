/// <reference path="../../../../../lib/app.d.ts" />
'use strict';

export var directiveName = 'setting';

class SettingDirective implements angular.IDirective {

  restrict = 'AC';

  template = '<a id="btn-setting" title="Setting" href="#"><i class="icon glyphicon glyphicon-cog"></i></a>';

  // <modelValue> → ngModelCtrl.$formatters(modelValue) → $viewValue
  //                                                        ↓
  // ↑                                                  $render()
  //                                                        ↓
  // ↑                                                  UI changed
  //                                                        ↓
  // ngModelCtrl.$parsers(newViewValue)    ←    $setViewValue(newViewValue)
  link = (scope: angular.IScope, el: angular.IAugmentedJQuery, attrs: any, ctrls) => {

    el.on('click', function () {
      $('.navbar-account').toggleClass('setting-open');
    });

  }

}

export var Directive = [ '$injector', ($injector: angular.auto.IInjectorService) => {
  return $injector.instantiate(SettingDirective);
}];