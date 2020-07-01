/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.resource.actions.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.language.Language;
import com.liferay.portal.kernel.model.ResourceAction;
import com.liferay.portal.kernel.service.ResourceActionLocalService;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.test.rule.Inject;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;

import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Sharry Shi
 */
@RunWith(Arquillian.class)
public class ResourceActionLanguageKeyTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new LiferayIntegrationTestRule();

	@Test
	public void testResourceActionLanguageKey() {
		for (ResourceAction resourceAction :
				_resourceActionLocalService.getResourceActions(
					0, _resourceActionLocalService.getResourceActionsCount())) {

			System.out.println(
				_language.get(
					LocaleUtil.ENGLISH,
					"action." + resourceAction.getActionId()));

			// The _language.get doesn't seem to get translations from modules

			// ResourceBundleLoaderUtil#ServiceTrackerMap?

		}
	}

	@Inject
	private Language _language;

	@Inject
	private ResourceActionLocalService _resourceActionLocalService;

}