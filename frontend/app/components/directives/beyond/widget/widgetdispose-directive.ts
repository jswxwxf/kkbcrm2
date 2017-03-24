/// <reference path="../../../../../lib/app.d.ts" />
'use strict';

export var directiveName = 'widgetDispose';

class WidgetDisposeDirective implements angular.IDirective {

  restrict = 'A';

  template = '<i class="fa fa-times"></i>';

  // <modelValue> → ngModelCtrl.$formatters(modelValue) → $viewValue
  //                                                        ↓
  // ↑                                                  $render()
  //                                                        ↓
  // ↑                                                  UI changed
  //                                                        ↓
  // ngModelCtrl.$parsers(newViewValue)    ←    $setViewValue(newViewValue)
  link = (scope: angular.IScope, el: angular.IAugmentedJQuery, attrs: any, ctrls) => {

    el.on('click', function () {
      var widget = el.parents(".widget").eq(0);
      var disposeinterval = 300;
      widget.hide(disposeinterval, function () {
        widget.remove();
      });
    });

  }

}

export var Directive = [ '$injector', ($injector: angular.auto.IInjectorService) => {
  return $injector.instantiate(WidgetDisposeDirective);
}];