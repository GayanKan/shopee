package shopee.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import shopee.api.data.CouponData;
import shopee.api.repository.PartnerRepository;
import shopee.api.data.PartnerData;
import shopee.api.repository.CouponRepository;

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
    public List<CouponData> getAllCoupons( @RequestParam(name = "name", required = false) String name, @RequestParam(name = "value", required = false) String value  )
    {
        Pageable paging = PageRequest.of(0, 20, Sort.by(Sort.Direction.ASC, "id"));

        Page<CouponData> pagedResult = couponRepository.findAll(paging);

        if(pagedResult.hasContent())
        {
            return pagedResult.getContent();
        }
        else
        {
            return new ArrayList<CouponData>();
        }
    }

    @GetMapping("/partners")
    public List<PartnerData> getAllPartners( @RequestParam(name = "name", required = false) String name )
    {
        Pageable paging = PageRequest.of(0, 20, Sort.by(Sort.Direction.ASC, "id"));

        Page<PartnerData> pagedResult = partnerRepository.findAll(paging);

        if(pagedResult.hasContent())
        {
            return pagedResult.getContent();
        }
        else
        {
            return new ArrayList<PartnerData>();
        }
    }
}
