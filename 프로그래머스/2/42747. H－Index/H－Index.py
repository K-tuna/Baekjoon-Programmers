def solution(citations):
    return len([sorted(citations)[i] for i in range(len(citations)) if sorted(citations)[i]>=len(citations)-i])