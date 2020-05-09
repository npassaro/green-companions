require 'test_helper'

class RelationTest < ActiveSupport::TestCase
  setup do
    @green = greens(:green_one)
    @companion = greens(:green_four).becomes(GoodCompanion)
  end

  test "add good companion to green" do
    assert_difference 'Companionship.count' do
      @green.good_companions << @companion
    end
  end

  test "add a companion as good and bad to the same green" do
    assert_raises ActiveRecord::RecordInvalid do
      @green.good_companions << @companion
      @green.bad_companions << @companion.becomes(BadCompanion)
    end
  end

  test "add a companion two times as good the same green" do
    assert_raises ActiveRecord::RecordInvalid do
      (1..2).each do
        @green.bad_companions << @companion.becomes(BadCompanion)
      end
    end
  end

  test "add a companion two times as bad the same green" do
    assert_raises ActiveRecord::RecordInvalid do
      (1..2).each do
        @green.bad_companions << @companion.becomes(BadCompanion)
      end
    end
  end

  test "add a companion to a green and the green as a companion" do
    assert_difference 'Companionship.count', 2 do
      @green.good_companions << @companion
      @companion.becomes(Green).bad_companions << @green.becomes(BadCompanion)
    end
  end
end
