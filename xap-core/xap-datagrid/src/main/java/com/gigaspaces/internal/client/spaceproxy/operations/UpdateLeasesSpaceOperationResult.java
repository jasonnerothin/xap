/*
 * Copyright (c) 2008-2016, GigaSpaces Technologies, Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.gigaspaces.internal.client.spaceproxy.operations;

import com.gigaspaces.internal.io.IOUtils;
import com.gigaspaces.internal.utils.Textualizer;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * @author Niv Ingberg
 * @since 9.0.0
 */
@com.gigaspaces.api.InternalApi
public class UpdateLeasesSpaceOperationResult extends SpaceOperationResult {
    private static final long serialVersionUID = 1L;

    private Exception[] _errors;

    /**
     * Required for Externalizable
     */
    public UpdateLeasesSpaceOperationResult() {
    }

    public Exception[] getErrors() {
        return _errors;
    }

    public void setErrors(Exception[] errors) {
        _errors = errors;
    }

    @Override
    public void toText(Textualizer textualizer) {
        super.toText(textualizer);
        textualizer.append("errors", _errors);
    }

    @Override
    public void writeExternal(ObjectOutput out)
            throws IOException {
        super.writeExternal(out);

        IOUtils.writeObjectArray(out, _errors);
    }

    @Override
    public void readExternal(ObjectInput in)
            throws IOException, ClassNotFoundException {
        super.readExternal(in);

        this._errors = IOUtils.readExceptionArray(in);
    }
}
