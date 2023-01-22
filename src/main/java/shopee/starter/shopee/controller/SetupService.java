package shopee.starter.shopee.controller;

import jakarta.servlet.http.Part;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import shopee.starter.shopee.data.Coupon;
import shopee.starter.shopee.data.Partner;
import shopee.starter.shopee.data.PartnerRepository;
import shopee.starter.shopee.data.Profile;
import shopee.starter.shopee.repository.CouponRepository;
import shopee.starter.shopee.repository.ProfileRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SetupService
{
    @Autowired
    private CouponRepository couponRepository;
    @Autowired
    private PartnerRepository partnerRepository;

    @GetMapping("/coupons")
    public List<Coupon> getAllCoupons(@RequestParam(name = "name", required = false) String name, @RequestParam(name = "value", required = false) String value  )
    {
        Pageable paging = PageRequest.of(0, 20, Sort.by(Sort.Direction.ASC, "id"));

        Page<Coupon> pagedResult = couponRepository.findAll(paging);

        if(pagedResult.hasContent())
        {
            return pagedResult.getContent();
        }
        else
        {
            return new ArrayList<Coupon>();
        }
    }

    @GetMapping("/partners")
    public List<Partner> getAllPartners(@RequestParam(name = "name", required = false) String name )
    {
        Pageable paging = PageRequest.of(0, 20, Sort.by(Sort.Direction.ASC, "id"));

        Page<Partner> pagedResult = partnerRepository.findAll(paging);

        if(pagedResult.hasContent())
        {
            return pagedResult.getContent();
        }
        else
        {
            return new ArrayList<Partner>();
        }
    }
}
