/**
 * The MIT License (MIT)
 * <p>
 * Copyright (c) 2023 the original author or authors.
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.bernardomg.example.netty.tcp.cli;

import java.io.PrintWriter;
import java.util.Objects;

import com.bernardomg.example.netty.tcp.server.ServerListener;

/**
 * Server listener which will write the context of each step into the CLI console.
 *
 * @author Bernardo Mart&iacute;nez Garrido
 *
 */
public final class CliWriterClientListener implements ServerListener {

    /**
     * Port which the server will listen to.
     */
    private final Integer     port;

    /**
     * CLI writer, to print console messages.
     */
    private final PrintWriter writer;

    public CliWriterClientListener(final Integer prt, final PrintWriter writ) {
        super();

        port = Objects.requireNonNull(prt);
        writer = Objects.requireNonNull(writ);
    }

    @Override
    public final void onReceive(final String response) {
        if (response.isEmpty()) {
            writer.println("Received no message");
        } else {
            writer.printf("Received message: %s", response);
            writer.println();
        }
    }

    @Override
    public final void onSend(final String request) {
        if (request.isEmpty()) {
            writer.println("Sent no message");
        } else {
            writer.printf("Sent message: %s", request);
            writer.println();
        }
    }

    @Override
    public final void onStart() {
        writer.printf("Starting server and listening to port %d", port);
        writer.println();
    }

    @Override
    public final void onStop() {
        writer.println("Stopping server");
    }

}
