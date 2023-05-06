/*
 * Copyright (c) 2023 by Gerrit Grunwald
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package eu.hansolo.fx.jdkmon.tools;

import eu.hansolo.fx.jdkmon.controls.MacosComboBoxCell;
import eu.hansolo.jdktools.LibCType;


public class MacosLibCTypeCell extends MacosComboBoxCell<LibCType> {

    @Override protected void updateItem(final LibCType libCType, final boolean empty) {
        super.updateItem(libCType, empty);

        if (empty || null == libCType) {
            setText(null);
            setGraphic(null);
        } else {
            setText(libCType.getUiString());
            setGraphic(isSelected() ? (isDark() ? WHITE_CHECK_MARK : BLACK_CHECK_MARK) : EMPTY_CHECK_MARK);
        }
    }

    @Override public String toString() {
        return getItem().getUiString();
    }
}

