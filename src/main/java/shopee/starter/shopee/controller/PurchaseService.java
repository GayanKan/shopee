package shopee.starter.shopee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import shopee.starter.shopee.data.Coupon;
import shopee.starter.shopee.repository.CouponRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PurchaseService
{
//    @Autowired
//    private CouponRepository couponRepository;
//    @GetMapping("/coupons")
//    public List<Coupon> getAllCoupons(@RequestParam(name = "name", required = false) String name, @RequestParam(name = "value", required = false) String value  )
//    {
//        Pageable paging = PageRequest.of(0, 20, Sort.by(Sort.Direction.ASC));
//
//        Page<Coupon> pagedResult = couponRepository.findAll(paging);
//
//        if(pagedResult.hasContent())
//        {
//            return pagedResult.getContent();
//        }
//        else
//        {
//            return new ArrayList<Coupon>();
//        }
//    }
}
