/// <reference path="../../../../../lib/app.d.ts" />
'use strict';

export var directiveName = 'widgetCollapse';

class WidgetCollapseDirective implements angular.IDirective {

  restrict = 'A';

  template = '<i class="fa fa-minus"></i>';

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
      var body = widget.find(".widget-body");
      var button = el.find("i");
      var down = "fa-plus";
      var up = "fa-minus";
      var slidedowninterval = 300;
      var slideupinterval = 200;
      if (widget.hasClass("collapsed")) {
        if (button) {
          button.addClass(up).removeClass(down);
        }
        widget.removeClass("collapsed");
        body.slideUp(0, function () {
          body.slideDown(slidedowninterval);
        });
      } else {
        if (button) {
          button.addClass(down)
            .removeClass(up);
        }
        body.slideUp(slideupinterval, function () {
          widget.addClass("collapsed");
        });
      }
    });

  }

}

export var Directive = [ '$injector', ($injector: angular.auto.IInjectorService) => {
  return $injector.instantiate(WidgetCollapseDirective);
}];