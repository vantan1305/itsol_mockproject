package itsol_project.itsolwebserver.service;

import itsol_project.itsolwebserver.dto.BaseDto;
import itsol_project.itsolwebserver.dto.OrderDto;
import itsol_project.itsolwebserver.entity.Order;
import itsol_project.itsolwebserver.entity.User;
import itsol_project.itsolwebserver.repository.OrderRepository;
import itsol_project.itsolwebserver.repository.UserRepository;
import itsol_project.itsolwebserver.service.iservice.OrderService;
import itsol_project.itsolwebserver.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OderServiceImpl implements OrderService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public  List<OrderDto> findAll() {
        return orderRepository.findAll()
                .stream()
                .map(obj -> AppUtil.mapperEntAndDto(obj, OrderDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public OrderDto saveOrUpdate(HttpServletRequest request, Object object) {
        Order order;
        OrderDto oderDTO = (OrderDto) object;
        if (oderDTO != null){
            //bajn giai thich cho mk cai dong nay
            // Nếu có userId thì truy vấn lấy thông tin user ko có thì null,null cũng đặt dc đúng k, uhm
            User user = AppUtil.NVL(oderDTO.getUserId()) != 0L ? userRepository.findById(oderDTO.getUserId()).orElse(null) : null;
            if (AppUtil.NVL(oderDTO.getId()) == 0L){
                order = AppUtil.mapperEntAndDto(oderDTO, Order.class);
                order.setCreatedDate(new Date());
                order.setUpdatedDate(new Date());
                order.setCode(AppUtil.generateOrderCode());
                order.setUser(user);
            }else {
                Order data = orderRepository.findById(oderDTO.getId()).orElse(null);
                if (data == null){
                    return null;
                }
                order = AppUtil.mapperEntAndDto(oderDTO, Order.class);
                order.setCode(data.getCode());
                order.setUpdatedDate(new Date());
                order.setUser(user);
            }
            return AppUtil.mapperEntAndDto(orderRepository.save(order), OrderDto.class);
        } // để test đã bạn, cái admin vẫn lỗi

        return null;
    }

    @Override
    public <T extends BaseDto> T findById(HttpServletRequest request, Long id) {
        return null;
        //giờ thay thế cái này bằng tìm kiếm theo code bạn nhỉ
    }

    @Override
    public Boolean delete(HttpServletRequest request, Long id) {
        //cái này delete giống những cái khác sau t viết
        Order oder = orderRepository.findById(id).orElse(null);
        if(oder != null){
            orderRepository.delete(oder);
            return true;
        }

        return false;
    }

    @Override
    public List<OrderDto> findByUserId(HttpServletRequest request, Long id) {
        List<Order> oder = orderRepository.findAllByUserId(id);
        if (oder !=null){
            return oder.stream().map(obj -> AppUtil.mapperEntAndDto(obj, OrderDto.class)).collect(Collectors.toList());
        }
        return  null;
    }
}
