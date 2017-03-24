/// <reference path="../../../../../lib/app.d.ts" />
'use strict';

export var directiveName = 'flotChartRealtime';

class FlotChartRealtimeDirective implements angular.IDirective {

  restrict = "AE";

  // <modelValue> → ngModelCtrl.$formatters(modelValue) → $viewValue
  //                                                        ↓
  // ↑                                                  $render()
  //                                                        ↓
  // ↑                                                  UI changed
  //                                                        ↓
  // ngModelCtrl.$parsers(newViewValue)    ←    $setViewValue(newViewValue)
  link = (scope: any, el: angular.IAugmentedJQuery, attrs: any, ctrls) => {

    var realTimedata,
      realTimedata2,
      totalPoints,
      getSeriesObj,
      getRandomData,
      getRandomData2,
      updateInterval,
      plot,
      update;

    return realTimedata = [],
      realTimedata2 = [],
      totalPoints = 300,
      getSeriesObj = function() {
        return [
          {
            data: getRandomData(),
            lines: {
              show: true,
              lineWidth: 1,
              fill: true,
              fillColor: {
                colors: [
                  {
                    opacity: 0
                  }, {
                    opacity: 1
                  }
                ]
              },
              steps: false
            },
            shadowSize: 0
          }, {
            data: getRandomData2(),
            lines: {
              lineWidth: 0,
              fill: true,
              fillColor: {
                colors: [
                  {
                    opacity: .5
                  }, {
                    opacity: 1
                  }
                ]
              },
              steps: false
            },
            shadowSize: 0
          }
        ];
      },
      getRandomData = function() {
        if (realTimedata.length > 0)
          realTimedata = realTimedata.slice(1);

        // Do a random walk

        while (realTimedata.length < totalPoints) {

          var prev = realTimedata.length > 0 ? realTimedata[realTimedata.length - 1] : 50,
            y = prev + Math.random() * 10 - 5;

          if (y < 0) {
            y = 0;
          } else if (y > 100) {
            y = 100;
          }
          realTimedata.push(y);
        }

        // Zip the generated y values with the x values

        var res = [];
        for (var i = 0; i < realTimedata.length; ++i) {
          res.push([i, realTimedata[i]]);
        }

        return res;
      },
      getRandomData2 = function() {
        if (realTimedata2.length > 0)
          realTimedata2 = realTimedata2.slice(1);

        // Do a random walk

        while (realTimedata2.length < totalPoints) {

          var prev = realTimedata2.length > 0 ? realTimedata[realTimedata2.length] : 50,
            y = prev - 25;

          if (y < 0) {
            y = 0;
          } else if (y > 100) {
            y = 100;
          }
          realTimedata2.push(y);
        }


        var res = [];
        for (var i = 0; i < realTimedata2.length; ++i) {
          res.push([i, realTimedata2[i]]);
        }

        return res;
      },

      // Set up the control widget
      updateInterval = 500,
      plot = $['plot'](el[0], getSeriesObj(), {
        yaxis: {
          color: '#f3f3f3',
          min: 0,
          max: 100,
          tickFormatter: function(val, axis) {
            return "";
          }
        },
        xaxis: {
          color: '#f3f3f3',
          min: 0,
          max: 100,
          tickFormatter: function(val, axis) {
            return "";
          }
        },
        grid: {
          hoverable: true,
          clickable: false,
          borderWidth: 0,
          aboveData: false
        },
        colors: ['#eee', scope.settings.color.themeprimary],
      }),
      update = function() {

        plot.setData(getSeriesObj());

        plot.draw();
        setTimeout(update, updateInterval);
      },
      update();


  }

}

export var Directive = [ '$injector', ($injector: angular.auto.IInjectorService) => {
  return $injector.instantiate(FlotChartRealtimeDirective);
}];