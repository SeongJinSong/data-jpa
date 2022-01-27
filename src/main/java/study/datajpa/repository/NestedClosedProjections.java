package study.datajpa.repository;

/**
 * 중첩 구조 처리
 * - 첫번째는 명시된 username 컬럼만 불러온다.
 * - team 은 최적화가 안되어서 모든 컬럼을 가져온다.
 */
public interface NestedClosedProjections {
    String getUsername();
    TeamInfo getTeam();
    interface TeamInfo {
        String getName();
    }
}
