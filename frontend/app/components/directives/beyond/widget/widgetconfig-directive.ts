/// <reference path="../../../../../lib/app.d.ts" />
'use strict';

export var directiveName = 'widgetConfig';

class WidgetConfigDirective implements angular.IDirective {

  restrict = 'A';

  template = '<i class="fa fa-cog"></i>';

  // <modelValue> → ngModelCtrl.$formatters(modelValue) → $viewValue
  //                                                        ↓
  // ↑                                                  $render()
  //                                                        ↓
  // ↑                                                  UI changed
  //                                                        ↓
  // ngModelCtrl.$parsers(newViewValue)    ←    $setViewValue(newViewValue)
  link = (scope: angular.IScope, el: angular.IAugmentedJQuery, attrs: any, ctrls) => {

    el.on('click', function () {
      //Do what you intend for configing widgets
    });

  }

}

export var Directive = [ '$injector', ($injector: angular.auto.IInjectorService) => {
  return $injector.instantiate(WidgetConfigDirective);
}];
