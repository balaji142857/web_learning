package com.krishnan.balaji.web.ajax;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = { "/dorpdown" })
public class TypeAheadDropDownServlet extends HttpServlet {

	private static final Logger log = Logger.getLogger(TypeAheadDropDownServlet.class.getName());
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("q");
		log.info("got reqeust for dropdown entries with "+name);
		StringBuilder buffer = new StringBuilder();
		for(String country : countries){
			if(country.toLowerCase().startsWith(name.toLowerCase()))
				buffer.append(country).append(System.lineSeparator());
		}
		resp.getWriter().println(buffer.toString());
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	static String[] countries = { "Andorra", "United Arab Emirates", "Afghanistan", "Antigua and Barbuda", "Anguilla",
			"Albania", "Armenia", "Netherlands Antilles", "Angola", "Antarctica", "Argentina", "American Samoa",
			"Austria", "Australia", "Aruba", "Azerbaijan", "Bosnia and Herzegovina", "Barbados", "Bangladesh",
			"Belgium", "Burkina Faso", "Bulgaria", "Bahrain", "Burundi", "Benin", "Bermuda", "Brunei", "Bolivia",
			"Brazil", "Bahamas", "Bhutan", "Bouvet Island", "Botswana", "Belarus", "Belize", "Canada",
			"Cocos [Keeling] Islands", "Congo [DRC]", "Central African Republic", "Congo [Republic]", "Switzerland",
			"C�te d'Ivoire", "Cook Islands", "Chile", "Cameroon", "China", "Colombia", "Costa Rica", "Cuba",
			"Cape Verde", "Christmas Island", "Cyprus", "Czech Republic", "Germany", "Djibouti", "Denmark", "Dominica",
			"Dominican Republic", "Algeria", "Ecuador", "Estonia", "Egypt", "Western Sahara", "Eritrea", "Spain",
			"Ethiopia", "Finland", "Fiji", "Falkland Islands [Islas Malvinas]", "Micronesia", "Faroe Islands", "France",
			"Gabon", "United Kingdom", "Grenada", "Georgia", "French Guiana", "Guernsey", "Ghana", "Gibraltar",
			"Greenland", "Gambia", "Guinea", "Guadeloupe", "Equatorial Guinea", "Greece",
			"South Georgia and the South Sandwich Islands", "Guatemala", "Guam", "Guinea-Bissau", "Guyana",
			"Gaza Strip", "Hong Kong", "Heard Island and McDonald Islands", "Honduras", "Croatia", "Haiti", "Hungary",
			"Indonesia", "Ireland", "Israel", "Isle of Man", "India", "British Indian Ocean Territory", "Iraq", "Iran",
			"Iceland", "Italy", "Jersey", "Jamaica", "Jordan", "Japan", "Kenya", "Kyrgyzstan", "Cambodia", "Kiribati",
			"Comoros", "Saint Kitts and Nevis", "North Korea", "South Korea", "Kuwait", "Cayman Islands", "Kazakhstan",
			"Laos", "Lebanon", "Saint Lucia", "Liechtenstein", "Sri Lanka", "Liberia", "Lesotho", "Lithuania",
			"Luxembourg", "Latvia", "Libya", "Morocco", "Monaco", "Moldova", "Montenegro", "Madagascar",
			"Marshall Islands", "Macedonia [FYROM]", "Mali", "Myanmar [Burma]", "Mongolia", "Macau",
			"Northern Mariana Islands", "Martinique", "Mauritania", "Montserrat", "Malta", "Mauritius", "Maldives",
			"Malawi", "Mexico", "Malaysia", "Mozambique", "Namibia", "New Caledonia", "Niger", "Norfolk Island",
			"Nigeria", "Nicaragua", "Netherlands", "Norway", "Nepal", "Nauru", "Niue", "New Zealand", "Oman", "Panama",
			"Peru", "French Polynesia", "Papua New Guinea", "Philippines", "Pakistan", "Poland",
			"Saint Pierre and Miquelon", "Pitcairn Islands", "Puerto Rico", "Palestinian Territories", "Portugal",
			"Palau", "Paraguay", "Qatar", "R�union", "Romania", "Serbia", "Russia", "Rwanda", "Saudi Arabia",
			"Solomon Islands", "Seychelles", "Sudan", "Sweden", "Singapore", "Saint Helena", "Slovenia",
			"Svalbard and Jan Mayen", "Slovakia", "Sierra Leone", "San Marino", "Senegal", "Somalia", "Suriname",
			"S�o Tom� and Pr�ncipe", "El Salvador", "Syria", "Swaziland", "Turks and Caicos Islands", "Chad",
			"French Southern Territories", "Togo", "Thailand", "Tajikistan", "Tokelau", "Timor-Leste", "Turkmenistan",
			"Tunisia", "Tonga", "Turkey", "Trinidad and Tobago", "Tuvalu", "Taiwan", "Tanzania", "Ukraine", "Uganda",
			"U.S. Minor Outlying Islands", "United States", "Uruguay", "Uzbekistan", "Vatican City",
			"Saint Vincent and the Grenadines", "Venezuela", "British Virgin Islands", "U.S. Virgin Islands", "Vietnam",
			"Vanuatu", "Wallis and Futuna", "Samoa", "Kosovo", "Yemen", "Mayotte", "South Africa", "Zambia",
			"Zimbabwe", };
}
