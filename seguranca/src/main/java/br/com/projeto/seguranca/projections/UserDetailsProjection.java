package br.com.projeto.seguranca.projections;

public interface UserDetailsProjection {
        String getUsername();
        String getPassword();
        Long getRoleId();
        String getAuthority();

}
