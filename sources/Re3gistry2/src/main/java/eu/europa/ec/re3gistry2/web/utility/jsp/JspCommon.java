/*
 * Copyright 2007,2016 EUROPEAN UNION
 * Licensed under the EUPL, Version 1.2 or - as soon they will be approved by
 * the European Commission - subsequent versions of the EUPL (the "Licence");
 * You may not use this work except in compliance with the Licence.
 * You may obtain a copy of the Licence at:
 *
 * https://ec.europa.eu/isa2/solutions/european-union-public-licence-eupl_en
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the Licence is distributed on an "AS IS" basis,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the Licence for the specific language governing permissions and
 * limitations under the Licence.
 *
 * Date: 2020/05/11
 * Authors:
 * European Commission, Joint Research Centre - jrc-inspire-support@ec.europa.eu
 *
 * This work was supported by the Interoperability solutions for public
 * administrations, businesses and citizens programme (http://ec.europa.eu/isa2)
 * through Action 2016.10: European Location Interoperability Solutions for e-Government (ELISE)
 */
package eu.europa.ec.re3gistry2.web.utility.jsp;

import eu.europa.ec.re3gistry2.base.utility.BaseConstants;
import eu.europa.ec.re3gistry2.model.RegItemproposed;
import eu.europa.ec.re3gistry2.model.RegUser;

public class JspCommon {

    private JspCommon() {
    }

    public static boolean canWrite(RegItemproposed regItemproposed, RegUser currentUser) {
        // Check if there are no proposals or if the user is the current owner of the proposal
        boolean currentUserOwnerOfProposal = (regItemproposed == null || (regItemproposed.getRegUser().getUuid().equals(currentUser.getUuid())));

        // Check if there are no proposals or if the proposed item is in draft status
        boolean proposalDraft = (regItemproposed == null
                || regItemproposed.getRegStatus().getLocalid().equals(BaseConstants.KEY_STATUS_LOCALID_DRAFT));

        return currentUserOwnerOfProposal && proposalDraft;
    }
}
