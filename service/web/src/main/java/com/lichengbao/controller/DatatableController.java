/**
 * 
 */
package com.lichengbao.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lichengbao.datatable.repository.AutozuDataTableRepository;
import com.lichengbao.datatable.repository.ClaimEntrapmentDataTableRepository;
import com.lichengbao.datatable.repository.DeviceDatatableRepository;
import com.lichengbao.datatable.repository.GreenPinganDataTableRepository;
import com.lichengbao.datatable.repository.Hunt2DataTableRepository;
import com.lichengbao.datatable.repository.HuntDataTableRepository;
import com.lichengbao.datatable.repository.MobileAssessmentDatatableRepository;
import com.lichengbao.datatable.repository.MonthlyAssessmentDatatableRepository;
import com.lichengbao.datatable.repository.Order10DatatableRepository;
import com.lichengbao.datatable.repository.Order15DatatableRepository;
import com.lichengbao.datatable.repository.OrderDatatableRepository;
import com.lichengbao.datatable.repository.OrderEntrapmentDataTableRepository;
import com.lichengbao.datatable.repository.OrderStolenDatatableRepository;
import com.lichengbao.datatable.repository.Quoted15DatatableRepository;
import com.lichengbao.datatable.repository.QuotedBackupDatatableRepository;
import com.lichengbao.datatable.repository.RegionDatatableRepository;
import com.lichengbao.datatable.repository.RewardDatatableRepository;
import com.lichengbao.datatable.repository.TripDatatableRepository;
import com.lichengbao.datatable.repository.UserAccountDatatableRepository;
import com.lichengbao.datatable.repository.UserBalanceDatatableRepository;
import com.lichengbao.datatable.repository.UserBeanDatatableRepository;
import com.lichengbao.datatable.repository.UserCardApplyDatatableRepository;
import com.lichengbao.datatable.repository.UserCardDatatableRepository;
import com.lichengbao.datatable.repository.UserDatatableRepository;
import com.lichengbao.datatable.repository.UserEncashDatatableRepository;
import com.lichengbao.datatable.repository.UserFeedbackDatatableRepository;
import com.lichengbao.datatable.repository.VehicleDatatableRepository;
import com.lichengbao.domain.assessment.MobileAssessment;
import com.lichengbao.domain.assessment.MonthlyAssessment;
import com.lichengbao.domain.common.Device;
import com.lichengbao.domain.common.Region;
import com.lichengbao.domain.common.Vehicle;
import com.lichengbao.domain.event.Autozu;
import com.lichengbao.domain.event.GreenPingan;
import com.lichengbao.domain.event.Hunt;
import com.lichengbao.domain.event.Hunt2;
import com.lichengbao.domain.insurance.ClaimEntrapment;
import com.lichengbao.domain.insurance.Quoted15;
import com.lichengbao.domain.insurance.QuotedBackup;
import com.lichengbao.domain.insurance.order.Order;
import com.lichengbao.domain.insurance.order.Order10;
import com.lichengbao.domain.insurance.order.Order15;
import com.lichengbao.domain.insurance.order.OrderEntrapment;
import com.lichengbao.domain.insurance.order.OrderStolen;
import com.lichengbao.domain.user.Reward;
import com.lichengbao.domain.user.Trip;
import com.lichengbao.domain.user.User;
import com.lichengbao.domain.user.UserAccount;
import com.lichengbao.domain.user.UserBalance;
import com.lichengbao.domain.user.UserBean;
import com.lichengbao.domain.user.UserCard;
import com.lichengbao.domain.user.UserCardApply;
import com.lichengbao.domain.user.UserEncash;
import com.lichengbao.domain.user.UserFeedback;
import com.lichengbao.specification.DefaultSpecifications;
import com.lichengbao.specification.DeviceSpecifications;
import com.lichengbao.specification.MobileAssessmentSpecifications;
import com.lichengbao.specification.MonthlyAssessmentSpecifications;
import com.lichengbao.specification.Order15Specifications;
import com.lichengbao.specification.OrderSpecifications;
import com.lichengbao.specification.Quoted15Specifications;
import com.lichengbao.specification.QuotedBackupSpecifications;
import com.lichengbao.specification.RewardSpecifications;
import com.lichengbao.specification.TripSpecifications;
import com.lichengbao.specification.UserAccountSpecifications;
import com.lichengbao.specification.UserBalanceSpecifications;
import com.lichengbao.specification.UserBeanSpecifications;
import com.lichengbao.specification.UserCardApplySpecifications;
import com.lichengbao.specification.UserCardSpecifications;
import com.lichengbao.specification.UserFeedbackSpecifications;
import com.lichengbao.specification.UserSpecifications;
import com.lichengbao.specification.VehicleSpecifications;

/**
 * @author jwang
 *
 */
@RestController
@RequestMapping("/datatable")
public class DatatableController {
	
	@Autowired
	private DefaultSpecifications defaultSpecifications;
	
	// =============================================================== /datatable/regions
	
	@Autowired
	private RegionDatatableRepository regionRepository;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/regions", method = RequestMethod.POST, produces = "application/json")
	public DataTablesOutput<Region> datatableRegions(@Valid DataTablesInput input) {
		Specification spec = defaultSpecifications.parseSearch(input.getSearch());
		return regionRepository.findAll(input, spec);
	}
	
	// =============================================================== /datatable/trips
	
	@Autowired
	private TripDatatableRepository tripRepository;
	
	@Autowired
	private TripSpecifications tripSpecifications;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/trips", method = RequestMethod.POST, produces = "application/json")
	public DataTablesOutput<Trip> datatableTrips(@Valid DataTablesInput input) {
		Specification spec = tripSpecifications.parseSearch(input.getSearch());
		return tripRepository.findAll(input, spec);
	}
	
	// =============================================================== /datatable/users
	
	@Autowired
	private UserDatatableRepository userRepository;
	
	@Autowired
	private UserSpecifications userSpecifications;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/users", method = RequestMethod.POST, produces = "application/json")
	public DataTablesOutput<User> datatableUsers(@Valid DataTablesInput input) {
		Specification spec = userSpecifications.parseSearch(input.getSearch());
		return userRepository.findAll(input, spec);
	}
	
	// =============================================================== /datatable/linkaccounts
	
	@Autowired
	private UserAccountDatatableRepository userAccountRepository;
	
	@Autowired
	private UserAccountSpecifications userAccountSpecifications;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/linkaccounts", method = RequestMethod.POST, produces = "application/json")
	public DataTablesOutput<UserAccount> datatableUserAccounts(@Valid DataTablesInput input) {
		Specification spec = userAccountSpecifications.parseSearch(input.getSearch());
		return userAccountRepository.findAll(input, spec);
	}
	
	// =============================================================== /datatable/cards
	
	@Autowired
	private UserCardDatatableRepository userCardRepository;
	
	@Autowired
	private UserCardSpecifications userCardSpecifications;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/cards", method = RequestMethod.POST, produces = "application/json")
	public DataTablesOutput<UserCard> datatableUserCards(@Valid DataTablesInput input) {
		Specification spec = userCardSpecifications.parseSearch(input.getSearch());
		return userCardRepository.findAll(input, spec);
	}
	
	// =============================================================== /datatable/beans
	
	@Autowired
	private UserBeanDatatableRepository userBeanRepository;
	
	@Autowired
	private UserBeanSpecifications userBeanSpecifications;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/beans", method = RequestMethod.POST, produces = "application/json")
	public DataTablesOutput<UserBean> datatableUserBeans(@Valid DataTablesInput input) {
		Specification spec = userBeanSpecifications.parseSearch(input.getSearch());
		return userBeanRepository.findAll(input, spec);
	}
	
	// =============================================================== /datatable/cards/applies
	
	@Autowired
	private UserCardApplyDatatableRepository userCardApplyRepository;
	
	@Autowired
	private UserCardApplySpecifications userCardApplySpecifications;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/cards/applies", method = RequestMethod.POST, produces = "application/json")
	public DataTablesOutput<UserCardApply> datatableUserCardApplies(@Valid DataTablesInput input) {
		Specification spec = userCardApplySpecifications.parseSearch(input.getSearch());
		return userCardApplyRepository.findAll(input, spec);
	}
	
	// =============================================================== /datatable/grades
	
	@Autowired
	private MobileAssessmentDatatableRepository mobileAssessmentRepository;
	
	@Autowired
	private MobileAssessmentSpecifications mobileAssessmentSpecifications;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/grades", method = RequestMethod.POST, produces = "application/json")
	public DataTablesOutput<MobileAssessment> datatableGrades(@Valid DataTablesInput input) {
		Specification spec = mobileAssessmentSpecifications.parseSearch(input.getSearch());
		return mobileAssessmentRepository.findAll(input, spec);
	}
	
	// =============================================================== /datatable/reports
	
	@Autowired
	private MonthlyAssessmentDatatableRepository monthlyAssessmentRepository;
	
	@Autowired
	private MonthlyAssessmentSpecifications monthlyAssessmentSpecifications;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/reports", method = RequestMethod.POST, produces = "application/json")
	public DataTablesOutput<MonthlyAssessment> datatableReports(@Valid DataTablesInput input) {
		Specification spec = monthlyAssessmentSpecifications.parseSearch(input.getSearch());
		return monthlyAssessmentRepository.findAll(input, spec);
	}

	// =============================================================== /datatable/balances
	
	@Autowired
	private UserBalanceDatatableRepository userBalanceRepository;
	
	@Autowired
	private UserBalanceSpecifications userBalanceSpecifications;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/balances", method = RequestMethod.POST, produces = "application/json")
	public DataTablesOutput<UserBalance> datatableUserBalance(@Valid DataTablesInput input) {
		Specification spec = userBalanceSpecifications.parseSearch(input.getSearch());
		return userBalanceRepository.findAll(input, spec);
	}
	
	// =============================================================== /datatable/encash
	
	@Autowired
	private UserEncashDatatableRepository userEncashRepository;
	
//	@Autowired
//	private UserSpecifications userSpecifications;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/encash", method = RequestMethod.POST, produces = "application/json")
	public DataTablesOutput<UserEncash> datatableUserEncash(@Valid DataTablesInput input) {
		Specification spec = defaultSpecifications.parseSearch(input.getSearch());
		return userEncashRepository.findAll(input, spec);
	}
	
	// =============================================================== /datatable/rewards
	
	@Autowired
	private RewardDatatableRepository rewardRepository;
	
	@Autowired
	private RewardSpecifications rewardSpecifications;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/rewards", method = RequestMethod.POST, produces = "application/json")
	public DataTablesOutput<Reward> datatableRewards(@Valid DataTablesInput input) {
		Specification spec = rewardSpecifications.parseSearch(input.getSearch());
		return rewardRepository.findAll(input, spec);
	}

	// =============================================================== /datatable/feedback
	
	@Autowired
	private UserFeedbackDatatableRepository userFeedbackRepository;
	
	@Autowired
	private UserFeedbackSpecifications userFeedbackSpecifications;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/feedback", method = RequestMethod.POST, produces = "application/json")
	public DataTablesOutput<UserFeedback> datatableUserFeedback(@Valid DataTablesInput input) {
		Specification spec = userFeedbackSpecifications.parseSearch(input.getSearch());
		return userFeedbackRepository.findAll(input, spec);
	}
	
	// =============================================================== /datatable/vehicles

	@Autowired
	private VehicleDatatableRepository vehicleRepository;
	
	@Autowired
	private VehicleSpecifications vehicleSpecifications;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/vehicles", method = RequestMethod.POST, produces = "application/json")
	public DataTablesOutput<Vehicle> datatableVehicles(@Valid DataTablesInput input) {
		Specification spec = vehicleSpecifications.parseSearch(input.getSearch());
		return vehicleRepository.findAll(input, spec);
	}
	
	// =============================================================== /datatable/devices

	@Autowired
	private DeviceDatatableRepository deviceRepository;
	
	@Autowired
	private DeviceSpecifications deviceSpecifications;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/devices", method = RequestMethod.POST, produces = "application/json")
	public DataTablesOutput<Device> datatableDevices(@Valid DataTablesInput input) {
		Specification spec = deviceSpecifications.parseSearch(input.getSearch());
		return deviceRepository.findAll(input, spec);
	}

	// =============================================================== /datatable/quotedhistory
	
	@Autowired
	private QuotedBackupDatatableRepository quotedBackupDatatableRepository;
	
	@Autowired
	private QuotedBackupSpecifications auotedBackupSpecifications;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/quotedhistory", method = RequestMethod.POST, produces = "application/json")
	public DataTablesOutput<QuotedBackup> datatableQuotedBackup(@Valid DataTablesInput input) {
		Specification spec = auotedBackupSpecifications.parseSearch(input.getSearch());
		return quotedBackupDatatableRepository.findAll(input, spec);
	}
	
	// =============================================================== /datatable/quoted15
	
	@Autowired
	private Quoted15DatatableRepository quoted15Repository;
	
	@Autowired
	private Quoted15Specifications quoted15Specifications;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/quoted15", method = RequestMethod.POST, produces = "application/json")
	public DataTablesOutput<Quoted15> datatableQuoted15(@Valid DataTablesInput input) {
		Specification spec = quoted15Specifications.parseSearch(input.getSearch());
		return quoted15Repository.findAll(input, spec);
	}
	

	// =============================================================== /datatable/orders
	
	@Autowired
	private OrderDatatableRepository orderRepository;
	
	@Autowired
	private OrderSpecifications orderSpecifications;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/orders", method = RequestMethod.POST, produces = "application/json")
	public DataTablesOutput<Order> datatableOrders(@Valid DataTablesInput input) {
		Specification spec = orderSpecifications.parseSearch(input.getSearch());
		return orderRepository.findAll(input, spec);
	}
	
	// =============================================================== /datatable/order15
	
	@Autowired
	private Order15DatatableRepository order15Repository;
	
	@Autowired
	private Order15Specifications order15Specifications;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/order15", method = RequestMethod.POST, produces = "application/json")
	public DataTablesOutput<Order15> datatableOrder15(@Valid DataTablesInput input) {
		Specification spec = order15Specifications.parseSearch(input.getSearch());
		return order15Repository.findAll(input, spec);
	}
	
	// =============================================================== /datatable/order10
	
	@Autowired
	private Order10DatatableRepository order10Repository;
	
//	@Autowired
//	private VehicleSpecifications vehicleSpecifications;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/order10", method = RequestMethod.POST, produces = "application/json")
	public DataTablesOutput<Order10> datatableOrder10(@Valid DataTablesInput input) {
		Specification spec = defaultSpecifications.parseSearch(input.getSearch());
		return order10Repository.findAll(input, spec);
	}
	

	// =============================================================== /datatable/entrapment/claims
	
	@Autowired
	private ClaimEntrapmentDataTableRepository claimEntrapmentRepository;
	
//	@Autowired
//	private VehicleSpecifications vehicleSpecifications;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/entrapment/claims", method = RequestMethod.POST, produces = "application/json")
	public DataTablesOutput<ClaimEntrapment> datatableClaimEntrapments(@Valid DataTablesInput input) {
		Specification spec = defaultSpecifications.parseSearch(input.getSearch());
		return claimEntrapmentRepository.findAll(input, spec);
	}
	
	// =============================================================== /datatable/entrapment/orders
	
	@Autowired
	private OrderEntrapmentDataTableRepository orderEntrapmentRepository;
	
//		@Autowired
//		private VehicleSpecifications vehicleSpecifications;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/entrapment/orders", method = RequestMethod.POST, produces = "application/json")
	public DataTablesOutput<OrderEntrapment> datatableOrderEntrapments(@Valid DataTablesInput input) {
		Specification spec = defaultSpecifications.parseSearch(input.getSearch());
		return orderEntrapmentRepository.findAll(input, spec);
	}
	
	// =============================================================== /datatable/events/autozu
	
	@Autowired
	private AutozuDataTableRepository autozuRepository;
	
//		@Autowired
//		private VehicleSpecifications vehicleSpecifications;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/events/autozu", method = RequestMethod.POST, produces = "application/json")
	public DataTablesOutput<Autozu> datatableAutozu(@Valid DataTablesInput input) {
		Specification spec = defaultSpecifications.parseSearch(input.getSearch());
		return autozuRepository.findAll(input, spec);
	}
	
	// =============================================================== /datatable/events/hunt
	
	@Autowired
	private HuntDataTableRepository huntRepository;
	
//		@Autowired
//		private VehicleSpecifications vehicleSpecifications;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/events/hunt", method = RequestMethod.POST, produces = "application/json")
	public DataTablesOutput<Hunt> datatableHunt(@Valid DataTablesInput input) {
		Specification spec = defaultSpecifications.parseSearch(input.getSearch());
		return huntRepository.findAll(input, spec);
	}
	
	// =============================================================== /datatable/events/hunt2
	
	@Autowired
	private Hunt2DataTableRepository hunt2Repository;
	
//		@Autowired
//		private VehicleSpecifications vehicleSpecifications;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/events/hunt2", method = RequestMethod.POST, produces = "application/json")
	public DataTablesOutput<Hunt2> datatableHunt2(@Valid DataTablesInput input) {
		Specification spec = defaultSpecifications.parseSearch(input.getSearch());
		return hunt2Repository.findAll(input, spec);
	}
	
	// =============================================================== /datatable/events/stolen
	
	@Autowired
	private OrderStolenDatatableRepository orderStolenRepository;
	
//		@Autowired
//		private VehicleSpecifications vehicleSpecifications;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/events/stolen", method = RequestMethod.POST, produces = "application/json")
	public DataTablesOutput<OrderStolen> datatableStolen(@Valid DataTablesInput input) {
		Specification spec = defaultSpecifications.parseSearch(input.getSearch());
		return orderStolenRepository.findAll(input, spec);
	}
	
	// =============================================================== /datatable/events/green
	
	@Autowired
	private GreenPinganDataTableRepository greenPinganRepository;
	
//		@Autowired
//		private VehicleSpecifications vehicleSpecifications;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/events/green", method = RequestMethod.POST, produces = "application/json")
	public DataTablesOutput<GreenPingan> datatableGreen(@Valid DataTablesInput input) {
		Specification spec = defaultSpecifications.parseSearch(input.getSearch());
		return greenPinganRepository.findAll(input, spec);
	}
	
}
