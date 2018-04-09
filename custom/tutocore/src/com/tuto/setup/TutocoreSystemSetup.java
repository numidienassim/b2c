/*
 * [y] hybris Platform
 *
 * Copyright (c) 2017 SAP SE or an SAP affiliate company.  All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package com.tuto.setup;

import static com.tuto.constants.TutocoreConstants.PLATFORM_LOGO_CODE;

import de.hybris.platform.core.initialization.SystemSetup;

import java.io.InputStream;

import com.tuto.constants.TutocoreConstants;
import com.tuto.service.TutocoreService;


@SystemSetup(extension = TutocoreConstants.EXTENSIONNAME)
public class TutocoreSystemSetup
{
	private final TutocoreService tutocoreService;

	public TutocoreSystemSetup(final TutocoreService tutocoreService)
	{
		this.tutocoreService = tutocoreService;
	}

	@SystemSetup(process = SystemSetup.Process.INIT, type = SystemSetup.Type.ESSENTIAL)
	public void createEssentialData()
	{
		tutocoreService.createLogo(PLATFORM_LOGO_CODE);
	}

	private InputStream getImageStream()
	{
		return TutocoreSystemSetup.class.getResourceAsStream("/tutocore/sap-hybris-platform.png");
	}
}
