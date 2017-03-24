/// <reference path="../../../lib/app.d.ts" />

'use strict';


export import commonService = require('./common-service');
export import userService = require('./user-service');
//export import carService = require('./car-service');
//export import deviceService = require('./device-service');
//export import insuranceService = require('./insurance-service');
//export import registerService = require('./register-service');
//export import wechatService = require('./wechat-service');
//export import orderService = require('./order-service');
//export import paymentService = require('./payment-service');
//export import claimService = require('./claim-service');
//export import walletService = require('./wallet-service');
//export import rewardService = require('./reward-service');

import httpInterceptor = require('./http-interceptor');

export var load = (app: angular.IModule) => {

  app.service(httpInterceptor.serviceName, httpInterceptor.Service)
    .service(commonService.serviceName, commonService.Service)
    .service(userService.serviceName, userService.Service);
  //  .service(carService.serviceName, carService.Service)
  //  .service(deviceService.serviceName, deviceService.Service)
  //  .service(insuranceService.serviceName, insuranceService.Service)
  //  .service(registerService.serviceName, registerService.Service)
  //  .service(orderService.serviceName, orderService.Service)
  //  .service(paymentService.serviceName, paymentService.Service)
  //  .service(wechatService.serviceName, wechatService.Service)
  //  .service(claimService.serviceName, claimService.Service)
  //  .service(walletService.serviceName, walletService.Service)
  //  .service(rewardService.serviceName, rewardService.Service);

  httpInterceptor.load(app);

};