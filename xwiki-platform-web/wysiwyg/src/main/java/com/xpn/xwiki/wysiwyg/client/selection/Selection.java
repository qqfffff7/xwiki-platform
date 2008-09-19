/*
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package com.xpn.xwiki.wysiwyg.client.selection;

import com.google.gwt.dom.client.Node;

public interface Selection
{
    /**
     * @return The node in which the selection begins.
     */
    Node getAnchorNode();

    /**
     * @return The offset within the (text) node where the selection begins.
     */
    int getAnchorOffset();

    /**
     * @return The node in which the selection ends.
     */
    Node getFocusNode();

    /**
     * @return The offset within the (text) node where the selection ends.
     */
    int getFocusOffset();

    /**
     * @return true if the selection is collapsed.
     */
    boolean isCollapsed();

    /**
     * @return The number of ranges in the selection.
     */
    int getRangeCount();

    /**
     * @return The range at the specified index.
     */
    Range getRangeAt(int index);

    /**
     * Collapses the selection to a single point, at the specified offset in the given DOM node. When the selection is
     * collapsed, and the content is focused and editable, the caret will blink there.
     * 
     * @param parentNode The given dom node where the selection will be set.
     * @param offset Where in given dom node to place the selection (the offset into the given node).
     */
    void collapse(Node parentNode, int offset);

    /**
     * Extends the selection by moving the selection end to the specified node and offset, preserving the selection
     * begin position. The new selection end result will always be from the anchorNode to the new focusNode, regardless
     * of direction.
     * 
     * @param parentNode The node where the selection will be extended to.
     * @param offset Where in node to place the offset in the new selection end.
     */
    void extend(Node parentNode, int offset);

    /**
     * Collapses the whole selection to a single point at the start of the current selection (irrespective of
     * direction). If content is focused and editable, the caret will blink there.
     */
    void collapseToStart();

    /**
     * Collapses the whole selection to a single point at the end of the current selection (irrespective of direction).
     * If content is focused and editable, the caret will blink there.
     */
    void collapseToEnd();

    /**
     * Indicates whether the node is part of the selection. If partlyContained is set to true, the function returns true
     * when some part of the node is part of the selection. If partlyContained is set to false, the function only
     * returns true when the entire node is part of the selection.
     */
    boolean containsNode(Node node, boolean partlyContained);

    /**
     * Adds all children of the specified node to the selection.
     * 
     * @param parentNode the parent of the children to be added to the selection.
     */
    void selectAllChildren(Node parentNode);

    /**
     * Adds a range to the current selection.
     */
    void addRange(Range range);

    /**
     * Removes a range from the current selection.
     */
    void removeRange(Range range);

    /**
     * Removes all ranges from the current selection.
     */
    void removeAllRanges();

    /**
     * Deletes this selection from document the nodes belong to.
     */
    void deleteFromDocument();

    /**
     * Modifies the cursor Bidi level after a change in keyboard direction
     * 
     * @param langRTL is true if the new language is right-to-left or false if the new language is left-to-right.
     */
    void selectionLanguageChange(boolean langRTL);
}
