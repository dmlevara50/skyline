package com.skyline.configure.security;

//public class JWTAuthorizationFilter extends OncePerRequestFilter {
public class JWTAuthorizationFilter {

//    private Claims setSigningKey(HttpServletRequest request) {
//        String jwtToken = request.
//                getHeader(HEADER_AUTHORIZACION_KEY).
//                replace(TOKEN_BEARER_PREFIX, "");
//
//        return Jwts.parser().setSigningKey(getSigningKey(SUPER_SECRET_KEY)).build().parseClaimsJws(jwtToken).getBody();
//    }
//
//    private void setAuthentication(Claims claims) {
//
//        List<String> authorities = (List<String>) claims.get("authorities");
//
//        UsernamePasswordAuthenticationToken auth =
//                new UsernamePasswordAuthenticationToken(claims.getSubject(), null,
//                        authorities.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
//
//        SecurityContextHolder.getContext().setAuthentication(auth);
//
//    }
//
//    private boolean isJWTValid(HttpServletRequest request, HttpServletResponse res) {
//        String authenticationHeader = request.getHeader(HEADER_AUTHORIZACION_KEY);
//        if (authenticationHeader == null || !authenticationHeader.startsWith(TOKEN_BEARER_PREFIX))
//            return false;
//        return true;
//    }
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        try {
//            if (isJWTValid(request, response)) {
//                Claims claims = setSigningKey(request);
//                if (claims.get("authorities") != null) {
//                    setAuthentication(claims);
//                } else {
//                    SecurityContextHolder.clearContext();
//                }
//            } else {
//                SecurityContextHolder.clearContext();
//            }
//            filterChain.doFilter(request, response);
//        } catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException e) {
//            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
//            response.sendError(HttpServletResponse.SC_FORBIDDEN, e.getMessage());
//            return;
//        }
//    }

}
