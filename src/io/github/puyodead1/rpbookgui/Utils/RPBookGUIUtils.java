/*******************************************************************************
 * Copyright 2019 Puyodead1
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License.  You may obtain a copy
 * of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations under
 * the License.
 ******************************************************************************/
package io.github.puyodead1.rpbookgui.Utils;

import org.bukkit.ChatColor;

public class RPBookGUIUtils {
	public static String ChatColor(String msg) {
		return ChatColor.translateAlternateColorCodes('&', msg);
	}

	public static int r(double i) {
		long a = Math.round(i / 9);
		if(a <= 1) {
			a++;
		}
		return (int) (a * 9);
	}

	public static String Strip(String message) {
		return ChatColor.stripColor(message);
	}
}
