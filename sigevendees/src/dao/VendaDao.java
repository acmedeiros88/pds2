package dao;

import entity.Venda;

public class VendaDao {
	public boolean salvar(Venda venda) {
		return GenericDao.salvar(venda);
	}
}
