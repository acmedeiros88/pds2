package conversores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import dao.ComponenteDao;
import entity.Componente;

@FacesConverter("componenteConverter")
public class ComponenteConverter implements Converter {
	@Inject
	private ComponenteDao dao = new ComponenteDao();

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null || value == "") {
			return null;
		}
		return dao.buscarPorCod(Integer.parseInt(value));
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object objComponente) {
		if (objComponente == null) {
			return null;
		}
		Componente comp = (Componente) objComponente;
		return Integer.toString(comp.getCodigo());
	}

}
