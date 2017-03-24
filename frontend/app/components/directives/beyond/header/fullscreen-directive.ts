/// <reference path="../../../../../lib/app.d.ts" />
'use strict';

export var directiveName = 'fullscreen';

class FullscreenDirective implements angular.IDirective {

  restrict = 'AC';

  template = '<i class="glyphicon glyphicon-fullscreen"></i>';

  // <modelValue> → ngModelCtrl.$formatters(modelValue) → $viewValue
  //                                                        ↓
  // ↑                                                  $render()
  //                                                        ↓
  // ↑                                                  UI changed
  //                                                        ↓
  // ngModelCtrl.$parsers(newViewValue)    ←    $setViewValue(newViewValue)
  link = (scope: angular.IScope, el: angular.IAugmentedJQuery, attrs: any, ctrls) => {

    el.on('click', function() {
      var element: any = document.documentElement;
      if (!$('body')
          .hasClass("full-screen")) {

        $('body')
          .addClass("full-screen");
        $('#fullscreen-toggler')
          .addClass("active");
        if (element.requestFullscreen) {
          element.requestFullscreen();
        } else if (element.mozRequestFullScreen) {
          element.mozRequestFullScreen();
        } else if (element.webkitRequestFullscreen) {
          element.webkitRequestFullscreen();
        } else if (element.msRequestFullscreen) {
          element.msRequestFullscreen();
        }

      } else {

        $('body').removeClass("full-screen");
        el.removeClass("active");

        if (document.exitFullscreen) {
          document.exitFullscreen();
        } else if (document['mozCancelFullScreen']) {
          document['mozCancelFullScreen']();
        } else if (document.webkitExitFullscreen) {
          document.webkitExitFullscreen();
        }

      }
    });

  }

}

export var Directive = [ '$injector', ($injector: angular.auto.IInjectorService) => {
  return $injector.instantiate(FullscreenDirective);
}];