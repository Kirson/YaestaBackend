package com.yaesta.app.persistence.util;

import java.util.ArrayList;
import java.util.List;

import com.yaesta.app.persistence.entity.Proveedor;
import com.yaesta.app.persistence.vo.ContactInfoVO;
import com.yaesta.app.persistence.vo.ContactVO;
import com.yaesta.app.persistence.vo.EmailVO;
import com.yaesta.app.persistence.vo.PersonVO;
import com.yaesta.app.persistence.vo.PhoneVO;

public class ContactInfoUtil {

	public static ContactInfoVO extractContactInfoFromSupplier(Proveedor supplier) {

		ContactInfoVO contactInfo = new ContactInfoVO();
		// Obtener toda la lista de emails
		if (supplier.getEmail() != null) {

			if (supplier.getEmail().trim().contains("\n")) {
				String email = supplier.getEmail().replace("\n", "");
				supplier.setEmail(email);
			}
			if (supplier.getEmail().trim().contains(" ")) {
				String emails[] = supplier.getEmail().trim().split(" ");

				for (int i = 0; i < emails.length; i++) {
					if (!emails[i].equals("")) {
						EmailVO emailVO = new EmailVO();
						emailVO.setEmail(emails[i]);
						if (i == 0) {
							contactInfo.setPrincipalEmail(emailVO);
						}
						contactInfo.getEmailList().add(emailVO);
					}

				}
			} else {
				EmailVO emailVO = new EmailVO();
				emailVO.setEmail(supplier.getEmail().trim());
				contactInfo.setPrincipalEmail(emailVO);
			}
		}
		// Obtener toda la lista de contactos
		if (supplier.getPersonaContacto() != null) {
			
			if (supplier.getPersonaContacto().trim().contains("\n")) {
				String personaContacto = supplier.getPersonaContacto().replace("\n", "");
				supplier.setPersonaContacto(personaContacto);
			}
			
			if (supplier.getPersonaContacto().trim().contains("-")) {
				String contacts[] = supplier.getPersonaContacto().trim().split("-");
				for (int i = 0; i < contacts.length; i++) {
					ContactVO contactVO = new ContactVO();
					contactVO.setName(contacts[i]);

					if (i == 0) {

						PersonVO personVO = new PersonVO();
						String person[] = contacts[i].split(" ");
						personVO.setFirstName(person[0]);
						personVO.setLastName(person[1]);
						contactInfo.setPrincipalContact(personVO);

					}
					contactInfo.getContactList().add(contactVO);

				} // fin del for

			} else {
				PersonVO personVO = new PersonVO();
				if (supplier.getPersonaContacto().trim().contains(" ")) {
					String person[] = supplier.getPersonaContacto().trim().split(" ");
					personVO.setFirstName(person[0]);
					personVO.setLastName(person[1]);
				} else {
					personVO.setFirstName(supplier.getPersonaContacto().trim());
				}
				contactInfo.setPrincipalContact(personVO);

			}
		}
		// Obtener la lista de telefonos
		if (supplier.getTelefono() != null) {
			if (supplier.getTelefono().trim().contains("\n")) {
				String telefono = supplier.getTelefono().replace("\n", "");
				supplier.setTelefono(telefono);
			}

			if (supplier.getTelefono().trim().contains(" ")) {

				String phones[] = supplier.getTelefono().trim().split(" ");

				for (int i = 0; i < phones.length; i++) {

					if (!phones[i].equals("")) {
						PhoneVO phoneVO = new PhoneVO();

						if (phones[i].trim().contains("EXT")) {

							System.out.println("EXT " + phones[i].trim());
							String phone[] = phones[i].trim().split("EXT");
							phoneVO.setPhone(phone[0]);
							System.out.println(phone[0]);
							System.out.println(phone[1]);

							if (phone[1].trim().contains("-")) {
								List<String> extList = new ArrayList<String>();
								String exts[] = phone[1].trim().split("-");
								for (int j = 0; j < exts.length; j++) {
									extList.add(exts[j]);
								}
								phoneVO.getExt().addAll(extList);
							} else {
								phoneVO.getExt().add(phone[1].trim());
							}

						} else {
							phoneVO.setPhone(phones[i].trim());
						}

						if (i == 0) {
							contactInfo.setPrincipalPhone(phoneVO);
						}

						contactInfo.getPhoneList().add(phoneVO);
					}
				} // fin del for

			} else {

				PhoneVO phoneVO = new PhoneVO();

				if (supplier.getTelefono().trim().contains("EXT")) {
					String phone[] = supplier.getTelefono().trim().split("EXT");
					phoneVO.setPhone(phone[0]);

					if (phone[1].trim().contains("-")) {
						List<String> extList = new ArrayList<String>();
						String exts[] = phone[1].trim().split("-");
						for (int j = 0; j < exts.length; j++) {
							extList.add(exts[j]);
						}
						phoneVO.getExt().addAll(extList);
					} else {
						phoneVO.getExt().add(phone[1].trim());
					}

				} else {
					phoneVO.setPhone(supplier.getTelefono().trim());
				}

				contactInfo.setPrincipalPhone(phoneVO);
			}
		}

		return contactInfo;

	}

}
