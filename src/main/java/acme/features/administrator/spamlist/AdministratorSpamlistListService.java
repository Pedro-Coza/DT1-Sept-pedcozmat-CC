
package acme.features.administrator.spamlist;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.spamlist.Spamlist;
import acme.entities.spamlist.Spamword;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractListService;

@Service
public class AdministratorSpamlistListService implements AbstractListService<Administrator, Spamlist> {

	@Autowired
	AdministratorSpamlistRepository	repository;

	private String					as1	= "";
	private String					as2	= "";
	private String					as3	= "";
	private String					as4	= "";
	private String					as5	= "";


	@Override
	public boolean authorise(final Request<Spamlist> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Spamlist> request, final Spamlist entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		StringBuilder buffer;
		Collection<Spamword> spamwords;

		request.unbind(entity, model, "threshold");

		spamwords = this.repository.findManySpamwordsById(entity.getId());
		buffer = new StringBuilder();
		buffer.append("[");
		Integer x = spamwords.size();
		Integer i = 0;
		for (Spamword word : spamwords) {
			buffer.append(word.getSpamword());
			if (i < x - 1) {
				buffer.append(", ");
			}
			i++;
		}

		model.setAttribute("spamwordslist", buffer.toString() + "]");
		model.setAttribute("as1", this.as1);
		model.setAttribute("as2", this.as2);
		model.setAttribute("as3", this.as3);
		model.setAttribute("as4", this.as4);
		model.setAttribute("as5", this.as5);

	}

	@Override
	public Collection<Spamlist> findMany(final Request<Spamlist> request) {
		assert request != null;

		Collection<Spamlist> result;

		result = this.repository.findManyAll();

		return result;
	}

}
