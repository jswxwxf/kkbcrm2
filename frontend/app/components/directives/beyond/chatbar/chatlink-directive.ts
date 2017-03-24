/// <reference path="../../../../../lib/app.d.ts" />
'use strict';

export var directiveName = 'chatLink';

class ChatLinkDirective implements angular.IDirective {

  restrict = 'AC';

  template = '<i class="icon glyphicon glyphicon-comment"></i>';

  // <modelValue> → ngModelCtrl.$formatters(modelValue) → $viewValue
  //                                                        ↓
  // ↑                                                  $render()
  //                                                        ↓
  // ↑                                                  UI changed
  //                                                        ↓
  // ngModelCtrl.$parsers(newViewValue)    ←    $setViewValue(newViewValue)
  link = (scope: angular.IScope, el: angular.IAugmentedJQuery, attrs: any, ctrls) => {

    el.on('click', function () {
      $('.page-chatbar').toggleClass('open');
      el.toggleClass('wave').toggleClass('in');
      el.parent().toggleClass('open');
    });

  }

}

export var Directive = [ '$injector', ($injector: angular.auto.IInjectorService) => {
  return $injector.instantiate(ChatLinkDirective);
}];