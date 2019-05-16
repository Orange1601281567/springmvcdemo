package business.service.impl;

import business.domain.Account;
import business.dao.IAccountDao;
import business.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService")
public class IAccountServiceImpl implements IAccountService {
    @Autowired
    private IAccountDao accountDao;

    @Override
    public List<Account> findAllAccount() {
        return accountDao.findAllAccount();
    }

    @Override
    public Account findAccountById(Integer accountId) {
        return accountDao.findAccountById( accountId );
    }

    @Override
    public void saveAccount(Account account) {
        accountDao.saveAccount( account );
    }

    @Override
    public void updateAccount(Account account) {
        accountDao.updateAccount( account );
    }

    @Override
    public void deleteAccount(Integer accountId) {
        accountDao.deleteAccount( accountId );
    }
}


