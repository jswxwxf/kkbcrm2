/// <reference path="../../../../../lib/app.d.ts" />
'use strict';

export var directiveName = 'pageChatbar';

class PageChatbarDirective implements angular.IDirective {

  restrict = 'AC';

  static $inject = ['$cookies'];

  constructor(private $cookies) {}

  // <modelValue> → ngModelCtrl.$formatters(modelValue) → $viewValue
  //                                                        ↓
  // ↑                                                  $render()
  //                                                        ↓
  // ↑                                                  UI changed
  //                                                        ↓
  // ngModelCtrl.$parsers(newViewValue)    ←    $setViewValue(newViewValue)
  link = (scope: any, el: angular.IAugmentedJQuery, attrs: any, ctrls) => {

    var additionalHeight = 0;
    if ($(window).width() < 531)
      additionalHeight = 45;
    var position = (this.$cookies.rtlSupport || location.pathname == "/index-rtl-fa.html" || location.pathname == "/index-rtl-ar.html") ? 'right' : 'left';
    $('.chatbar-messages .messages-list')['slimscroll']({
      position: position,
      size: '4px',
      color: scope.settings.color.themeprimary,
      height: $(window).height() - (250 + additionalHeight),
    });
    $('.chatbar-contacts .contacts-list')['slimscroll']({
      position: position,
      size: '4px',
      color: scope.settings.color.themeprimary,
      height: $(window).height() - (86 + additionalHeight),
    });
    el.on('click', '.chatbar-contacts .contact', function () {
      el.find('.chatbar-contacts').hide();
      el.find('.chatbar-messages').show();
    });

    el.on('click', '.chatbar-messages .back', function () {
      el.find('.chatbar-messages').hide();
      el.find('.chatbar-contacts').show();
    });

  }

}

export var Directive = [ '$injector', ($injector: angular.auto.IInjectorService) => {
  return $injector.instantiate(PageChatbarDirective);
}];