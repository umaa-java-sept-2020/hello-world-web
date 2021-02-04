package com.java.filters;

/**
 * 1. Implement from javax filter
 * 2. configure in web.xml with url pattern such that it will delegate the request to EmployeeServlet.
 * 3. Display the postProcessing and preProcessing.
 * 4. Implement init and destroy.
 * 4.1 configure init params for filter in web.xml.
 * 5. Display context params and filter config params.
 *
 *
 * Advance
 * 6. Use multiple filters before a servlet with same URL pattern
 * 7. Use multiple filters such that f1 has url pattern, that will delegate to f2 by filter name, f2 will delegate to a servlet s1 with servlet name.
 *
 */
public class EmployeeFilter {
}
