package shopee.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shopee.api.repository.PartnerRepository;
import shopee.api.service.IAdminService;
import shopee.api.data.ProfileData;

@Service
@Scope("prototype")
public class AdminServiceImpl implements IAdminService
{
    @Autowired
    PartnerRepository partnerRepository;

    @Transactional(readOnly = true)
    @Override
    public ProfileData getDetailUserProfile( Long profileId )
    {
        return null;
    }
}
